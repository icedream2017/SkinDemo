package org.sakura.skindemo.theme;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@SuppressWarnings("all")
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface ThemeStyle {
    String DEFAULT = "Theme.SkinDemo";
    String GANYU = "Theme.SkinDemo.Ganyu";
    String HUTAO = "Theme.SkinDemo.Hutao";
    String KEQING = "Theme.SkinDemo.Keqing";
    String XIANGLING = "Theme.SkinDemo.Xiangling";
    String XIAO = "Theme.SkinDemo.Xiao";
    String ZHONGLI = "Theme.SkinDemo.Zhongli";
}
