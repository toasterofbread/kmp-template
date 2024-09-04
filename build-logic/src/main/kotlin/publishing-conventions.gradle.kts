import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.KotlinMultiplatform

plugins {
    id("com.vanniktech.maven.publish")
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    configure(KotlinMultiplatform(
        sourcesJar = true
    ))

    pom {
        name.set("kmp-template")
        description.set("Kotlin Multiplatform Library Template")
        url.set("https:/github.com/toasterofbread/kmp-template")
        inceptionYear.set("2024")

        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("toasterofbread")
                name.set("Talo Halton")
                email.set("talohalton@gmail.com")
                url.set("https://github.com/toasterofbread")
            }
        }
        scm {
            connection.set("https://github.com/toasterofbread/kmp-template.git")
            url.set("https://github.com/toasterofbread/kmp-template")
        }
        issueManagement {
            system.set("Github")
            url.set("https://github.com/toasterofbread/kmp-template/issues")
        }
    }
}
