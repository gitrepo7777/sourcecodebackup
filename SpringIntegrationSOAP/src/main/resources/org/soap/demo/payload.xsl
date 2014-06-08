<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
				xmlns:soap="http://www.w3.org/2001/12/soap-envelope">
	<xsl:template match="/">
	  <xsl:copy-of select="/soap:Envelope/soap:Body/node()"/>
	</xsl:template>
</xsl:stylesheet>