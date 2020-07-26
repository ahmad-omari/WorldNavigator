package GameObjects;

public class ImagesPath {
    public static String getPath(String imageRequest){
        if (imageRequest.equals("door")){
            return "icons/doorimg.png";
        }else if(imageRequest.equals("mirror")){
            return "icons/mirrorimg.png";
        }else if (imageRequest.equals("painting")){
            return "icons/paintingimg.png";
        }else if (imageRequest.equals("seller")){
            return "icons/sellerimg.png";
        }else if (imageRequest.equals("chest")){
            return "icons/chestimg.png";
        }else if (imageRequest.equals("plainwall")){
            return "icons/plainwallimg.png";
        }else {
            return "";
        }
    }

    public static String getArrowPath(int imageRequest,String side){
        switch (imageRequest){
            case 0:
                if (side.equals("north")) {
                    return "icons/uparrow.png";
                }
                break;
            case 1:
                if (side.equals("south")) {
                    return "icons/downarrow.png";
                }
                break;
            case 2:
                if (side.equals("east")) {
                    return "icons/leftarrow.png";
                }
                break;
            case 3:
                if (side.equals("west")) {
                    return "icons/rightarrow.png";
                }
        }
        return "";
    }
}
