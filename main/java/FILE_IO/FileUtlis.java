package FILE_IO;

import java.io.File;

public class FileUtlis {
    public static boolean deleteFiles(File contantsToDelete){
        File[] allContents = contantsToDelete.listFiles();
        if(allContents != null){
            for(File file : allContents){
                deleteFiles(file);
            }
        }
        return contantsToDelete.delete();
    }
}
