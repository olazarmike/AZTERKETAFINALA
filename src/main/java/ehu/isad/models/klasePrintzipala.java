package ehu.isad.models;

public class klasePrintzipala { //egitura, atributu egokiak jarri, pantailetan erabiltzen direnak
    //private String url;
    private String md5;
    private String version;

    public klasePrintzipala(String pMd5, String pVersion) {
        //this.url = pUrl;
        this.md5 = pMd5;
        this.version = pVersion;
    }

    //public String getURL() { return url; }

    public String getMd5() {
        return md5;
    }

    public String getVersion() {
        return version;
    }

}
