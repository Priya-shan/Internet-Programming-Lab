<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : samp.xsl
    Created on : 2 June, 2022, 3:38 PM
    Author     : welcom
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
            <html>
            <body>
                <h1>Student Details</h1>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Dept</th>
                        <th>Cgpa</th>
                    </tr>
                    <xsl:for-each select="college/student">
                        <xsl:choose>
                            <xsl:when test="Dept = 'CSE'">
                        <tr bgcolor="yellow">
                            <td>
                                <xsl:value-of select="Name"/>
                            </td>
                      
                            <td>
                                <xsl:value-of select="Dept"/>
                            </td>
                                
                            <td>
                                <xsl:value-of select="cgpa"/>
                            </td>
                                   
                        </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr>
                            <td>
                                <xsl:value-of select="Name"/>
                            </td>
                      
                            <td>
                                <xsl:value-of select="Dept"/>
                            </td>
                                
                            <td>
                                <xsl:value-of select="cgpa"/>
                            </td>
                                   
                        </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:for-each>
                </table>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>
