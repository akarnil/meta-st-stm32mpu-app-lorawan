DESCRIPTION = "chirpstack gateway bridge"
HOMEPAGE = "https://www.chirpstack.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bc4546f147d6f9892ca1b7d23bf41196"

SRC_URI = "https://artifacts.chirpstack.io/downloads/chirpstack-gateway-bridge/chirpstack-gateway-bridge_4.0.10_linux_armv7.tar.gz"
SRC_URI[md5sum] = "17071b0544c5ec14b10ccbb9c91a988a"
SRC_URI[sha256sum] = "9229263c08a9a5c7cd814474783a3c4e07df1039c1642b8831971f39ef0d87ce"
SRC_URI += "file://chirpstack-gateway-bridge.service"
SRC_URI += "file://chirpstack-gateway-bridge.toml"

INSANE_SKIP:${PN} += "already-stripped"

S = "${WORKDIR}"

do_install:append() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/chirpstack-gateway-bridge ${D}${bindir}

	install -d ${D}/etc/chirpstack-gateway-bridge
	install -m 0640 ${S}/chirpstack-gateway-bridge.toml ${D}/etc/chirpstack-gateway-bridge/

	install -d ${D}/etc/systemd/system/
	install -m 0644 ${S}/chirpstack-gateway-bridge.service ${D}/etc/systemd/system/
}

FILES:${PN} += "${bindir}"
