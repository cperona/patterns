plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Source: https://mvnrepository.com/artifact/com.itextpdf/itextpdf
    implementation("com.itextpdf:itextpdf:5.5.13.5")
    implementation("org.apache.pdfbox:pdfbox:2.0.27")
    // Source: https://mvnrepository.com/artifact/org.odftoolkit/odfdom-java
    implementation("org.odftoolkit:odfdom-java:0.13.0")
    // Source: https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.17")
}

tasks.test {
    useJUnitPlatform()
}