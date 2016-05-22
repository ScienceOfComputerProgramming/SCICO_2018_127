/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.devbaltasarq.pooi.core;

/**
 * Info about app's version
 * @author baltasarq
 */
public class AppInfo {
    public static final String Name = "Pooi";
    public static final String Email = "jbgarcia@uvigo.es";
    public static final String Author = "Baltasar García Perez-Schofield";
    public static final String Version = "1.6 2016021";
    public static final String License = "MIT License: https://opensource.org/licenses/MIT";

    public static String getMsgVersion()
    {
        if ( msgVersion.isEmpty() ) {
            msgVersion = Name + " v" + Version;
        }

        return msgVersion;
    }

    private static String msgVersion = "";
}
