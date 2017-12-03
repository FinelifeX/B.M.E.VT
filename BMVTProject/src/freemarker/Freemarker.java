package freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Bulat Murtazin on 27.11.2017 -> 22:49
 * KPFU ITIS 11-601
 **/


public class Freemarker {
    private static Freemarker freemarker = new Freemarker();
    private static Configuration cfg;

    private Freemarker() {
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_27);
            cfg.setDirectoryForTemplateLoading(new File(
                    "C:\\Users\\User\\Desktop\\BMEVT\\project_in_repo\\B.M.E.VT\\BMVTProject\\web\\design\\pages"
            ));
            cfg.setDefaultEncoding("utf-8");
            cfg.setLocale(Locale.ENGLISH);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getCfg() {
        return cfg;
    }
}
