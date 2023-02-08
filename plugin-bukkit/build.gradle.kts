import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

fun commitHash(): String = try {
    val runtime = Runtime.getRuntime()
    val process = runtime.exec("git rev-parse --short HEAD")
    val out = process.inputStream
    out.bufferedReader().readText().trim()
} catch (ignored: Exception) {
    "unknown"
}

val commit: String? = commitHash()

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")

    implementation("com.google.code.gson:gson:2.9.1")
    implementation("org.mongodb:mongodb-driver-legacy:4.7.1")
    implementation("redis.clients:jedis:4.3.0-m1")
}

tasks.named<ShadowJar>("shadowJar") {
    this.archiveClassifier.set(null as String?)
    this.archiveFileName.set("${project.name}-${project.version}.${this.archiveExtension.getOrElse("jar")}")
    this.destinationDirectory.set(file("$projectDir/../out"))
}
