import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FotoContainer {
    private File showerr = new File(PropUtil.getProperty("Shower"));
   private File duty = new File(PropUtil.getProperty("Duty"));
   private File hall = new File(PropUtil.getProperty("Hall"));
   private File administration = new File(PropUtil.getProperty("Administration"));
   private File tennis = new File(PropUtil.getProperty("Tennis"));
    private InputFile shower = new InputFile(showerr);
   private InputFile Duty = new InputFile(duty);
   private InputFile Hall = new InputFile(hall);
   private InputFile Tennis = new InputFile(tennis);
   private InputFile Administration = new InputFile(administration);
  private Map<String, InputFile> Photos = new HashMap<>();
  private void Full(){
      Photos.put("shower",shower);
      Photos.put("Duty",Duty);
      Photos.put("Hall",Hall);
      Photos.put("Tennis",Tennis);
      Photos.put("Administration",Administration);
  }
  public InputFile get(String name){
      return Photos.get(name);
  }
}

