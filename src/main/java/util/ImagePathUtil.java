package util;

import org.apache.commons.lang.StringUtils;

public class ImagePathUtil {

    private static String jpg = ".jpg";

    /**
     * http://host/images/JHSLKSNCHSKSDNC --> JHSLKSNCHSKSDNC
     * http://host/images/JHSLKSNCHSKSDNC.jpg --> JHSLKSNCHSKSDNC
     * http://host/group1/M00/00/4E/rB8JClORiZeAYP5WAAGf.jpg --> /group1/M00/00/4E/rB8JClORiZeAYP5WAAGf
     */
    public static String removeImagePath(String path) {
        if (StringUtils.isBlank(path)) {
            return "";
        }
        if (path.startsWith("http")) {
            int index = path.indexOf("/", path.length() < 8 ? path.length() - 1 : 8);
            path = path.substring(index <= 0 ? 0 : index);
        }
        if (!path.startsWith("/group") && !path.startsWith("group")) {
            path = path.substring(path.lastIndexOf("/") + 1);
        }
        String jpg = ".jpg";
        if (path.endsWith(jpg)) {
            path = path.substring(0, path.length() - jpg.length());
        }
        return path;
    }

    public static String removeImagePaths(String paths) {
        if (StringUtils.isNotBlank(paths)) {
            String[] images = paths.split(",");
            for (int i = 0; i < images.length; i++) {
                images[i] = ImagePathUtil.removeImagePath(images[i]);
            }
            return StringUtils.join(images, ",");
        }
        return paths;
    }

    /**
     * 添加前缀，拼接成完整路径
     * <p/>
     * /group1/M00/00/4E/rB8JClORiZeAYP5WAAGf > http://pic001.51auto.com/group1/M00/00/4E/rB8JClORiZeAYP5WAAGf.jpg
     * group1/M00/00/4E/rB8JClORiZeAYP5WAAGf > http://pic001.51auto.com/group1/M00/00/4E/rB8JClORiZeAYP5WAAGf.jpg
     * JHSLKSNCHSKSDNC > http://pic001.ttpaicdn.com/images/JHSLKSNCHSKSDNC.jpg
     * /JHSLKSNCHSKSDNC > http://pic001.ttpaicdn.com/images/JHSLKSNCHSKSDNC.jpg
     * http://172.16.2.58/v1/tfs/JHSLKSNCHSKSDNC >http://pic001.ttpaicdn.com/images/JHSLKSNCHSKSDNC.jpg
     */
    public static String addImagePath(String path) {
        if (StringUtils.isBlank(path)) {
            return "";
        }
        if (path.startsWith("/group") || path.startsWith("group")) {
            path = concatImagePath(Constants.OLD_CRM_IMAGE_PATH, path);
        } else if (!path.startsWith("http")) {
            path = concatImagePath(Constants.BOSS_TFS_URL, path);
        }
        return path;
    }

    /**
     * 图片域名与路径拼接，主要对是否是 “/” 开头或者 “/” 结尾的情况进行拼接
     */
    public static String concatImagePath(String pathHost, String imagePath) {
        if (!pathHost.endsWith("/")) {
            pathHost += "/";
        }
        if (imagePath.startsWith("/")) {
            imagePath = imagePath.substring(1, imagePath.length());
        }
        if (imagePath.endsWith(jpg)) {
            return pathHost + imagePath;

        } else {
            return pathHost + imagePath + jpg;
        }
    }

    public static void main(String[] args) {
        System.out.println(removeImagePath("http://172.16.2.58/v1/tfs/JHSLKSNCHSKSDNC"));
        System.out.println(removeImagePath("http://pic001.51auto.com/group1/M00/00/4E/rB8JClORiZeAYP5WAAGf.jpg"));
        System.out.println(removeImagePath("https://172.16.2.58/images/JHSLKSNCHSKSDNC"));
        System.out.println(removeImagePath("https://pic001.51auto.com/group1/M00/00/4E/rB8JClORiZeAYP5WAAGf.jpg"));

        System.out.println();

        System.out.println(addImagePath("JHSLKSNCHSKSDNC"));
        System.out.println(addImagePath("group1/M00/00/4E/rB8JClORiZeAYP5WAAGf"));
        System.out.println(addImagePath("/JHSLKSNCHSKSDNC"));
        System.out.println(addImagePath("/group1/M00/00/4E/rB8JClORiZeAYP5WAAGf"));


    }


}