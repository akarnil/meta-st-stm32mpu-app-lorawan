DESCRIPTION = "chirpstack network server"
HOMEPAGE = "https://www.chirpstack.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e52a56a5b272102f5f53d67fdc2dd122"
LICENSE_PATH += "file://LICENSE"

SRC_URI = "https://artifacts.chirpstack.io/downloads/chirpstack-network-server/chirpstack-network-server_3.16.8_linux_armv7.tar.gz"
SRC_URI[md5sum] = "986fc94efc5957652ff5657dd1a08ca5"
SRC_URI[sha256sum] = "2654def780a784c52f970a5c5b1cbc6e8c96c6df89a57f65d5bb22afc1c1ca2f"

SRC_URI += "file://chirpstack-network-server.service"
SRC_URI += "file://chirpstack-network-server.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-1.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-2.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-3.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-4.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-1-lbt.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-2-lbt.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-3-lbt.toml"
SRC_URI += "file://config/chirpstack-network-server.as923-4-lbt.toml"
SRC_URI += "file://config/chirpstack-network-server.kr920-923-lbt.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-1.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-2.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-3.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-4.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-5.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-6.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-7.toml"
SRC_URI += "file://config/chirpstack-network-server.au915-928-8.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-1.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-2.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-3.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-4.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-5.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-6.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-7.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-8.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-9.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-10.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-11.toml"
SRC_URI += "file://config/chirpstack-network-server.cn470-510-12.toml"
SRC_URI += "file://config/chirpstack-network-server.cn779-787-1.toml"
SRC_URI += "file://config/chirpstack-network-server.eu433-434-1.toml"
SRC_URI += "file://config/chirpstack-network-server.eu863-870-1.toml"
SRC_URI += "file://config/chirpstack-network-server.in865-867-1.toml"
SRC_URI += "file://config/chirpstack-network-server.kr920-923-1.toml"
SRC_URI += "file://config/chirpstack-network-server.ru864-870-1.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-1.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-2.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-3.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-4.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-5.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-6.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-7.toml"
SRC_URI += "file://config/chirpstack-network-server.us902-928-8.toml"

INSANE_SKIP:${PN} += "already-stripped"

S = "${WORKDIR}"

do_install:append() {
	install -d ${D}${bindir}
	install -m 0755 chirpstack-network-server ${D}${bindir}/

	install -d ${D}/etc/chirpstack-network-server/
	install -m 0640 ${S}/chirpstack-network-server.toml ${D}/etc/chirpstack-network-server/chirpstack-network-server.toml

	install -d ${D}/etc/chirpstack-network-server/config
	install -m 0640 ${S}/config/* ${D}/etc/chirpstack-network-server/config

	install -d ${D}/etc/systemd/system/
	install -m 0644 ${S}/chirpstack-network-server.service ${D}/etc/systemd/system/
}

FILES:${PN} += "${bindir}"
