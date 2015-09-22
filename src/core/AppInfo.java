/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 * Info about app's version
 * @author baltasarq
 */
public class AppInfo {
    public static final String Name = "Pooi";
    public static final String Email = "jbgarcia@uvigo.es";
    public static final String Author = "Baltasar García Perez-Schofield";
    public static final String Version = "0.81 20140707";

    public static String getMsgVersion()
    {
        if ( msgVersion.isEmpty() ) {
            msgVersion = Name + " v" + Version;
        }

        return msgVersion;
    }

    private static String msgVersion = "";
}
