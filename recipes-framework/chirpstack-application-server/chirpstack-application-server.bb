DESCRIPTION = "chirpstack application Server"
HOMEPAGE = "https://www.chirpstack.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5301050fd7cd58850085239d559297be"

SRC_URI = "https://artifacts.chirpstack.io/downloads/chirpstack-application-server/chirpstack-application-server_3.17.9_linux_armv7.tar.gz"
SRC_URI[md5sum] = "1280c522c32fa9fa27f21b9acb248356"
SRC_URI[sha256sum] = "f025226a79cff8d97961e3c6d556c843e4da4cc2b719dd20165d87309bc26d8e"
SRC_URI += "file://chirpstack-application-server.service"
SRC_URI += "file://chirpstack-application-server.toml"

INSANE_SKIP:${PN} += "already-stripped"

S = "${WORKDIR}"

do_install:append() {
	install -d ${D}${bindir}
	install -m 0755 chirpstack-application-server ${D}${bindir}

	install -d ${D}/etc/chirpstack-application-server/
	install -m 0640 ${S}/chirpstack-application-server.toml ${D}/etc/chirpstack-application-server/chirpstack-application-server.toml

	install -d ${D}/etc/systemd/system/
	install -m 0644 ${S}/chirpstack-application-server.service ${D}/etc/systemd/system/
}

FILES:${PN} += "${bindir}"
