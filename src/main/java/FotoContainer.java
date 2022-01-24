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
    private File FK = new File(PropUtil.getProperty("FK"));
    private File SK= new File(PropUtil.getProperty("SK"));
    private File TK = new File(PropUtil.getProperty("TK"));
    private File LK = new File(PropUtil.getProperty("LK"));
    private File FB = new File(PropUtil.getProperty("FB"));
    private File SB= new File(PropUtil.getProperty("SB"));
    private File TB = new File(PropUtil.getProperty("TB"));
    private File LB = new File(PropUtil.getProperty("LB"));
    private File FLC = new File(PropUtil.getProperty("FLC"));
    private File SLC = new File(PropUtil.getProperty("SLC"));
    private File TLC = new File(PropUtil.getProperty("TLC"));
    private File LLC = new File(PropUtil.getProperty("LLC"));
    private File FRC = new File(PropUtil.getProperty("FRC"));
    private File SRC = new File(PropUtil.getProperty("SRC"));
    private File TRC = new File(PropUtil.getProperty("TRC"));
    private File LRC = new File(PropUtil.getProperty("LRC"));
    private InputFile shower = new InputFile(showerr);
   private InputFile Duty = new InputFile(duty);
   private InputFile Hall = new InputFile(hall);
   private InputFile Tennis = new InputFile(tennis);
   private InputFile Administration = new InputFile(administration);
    private InputFile fk = new InputFile(FK);
    private InputFile sk = new InputFile(SK);
    private InputFile tk = new InputFile(TK);
    private InputFile lk = new InputFile(LK);
    private InputFile fb = new InputFile(FB);
    private InputFile sb = new InputFile(SB);
    private InputFile tb = new InputFile(TB);
    private InputFile lb = new InputFile(LB);
    private InputFile flc = new InputFile(FLC);
    private InputFile slc = new InputFile(SLC);
    private InputFile tlc = new InputFile(TLC);
    private InputFile llc = new InputFile(LLC);
    private InputFile frc = new InputFile(FRC);
    private InputFile src = new InputFile(SRC);
    private InputFile trc = new InputFile(TRC);
    private InputFile lrc = new InputFile(LRC);
  private Map<String, InputFile> Photos = new HashMap<>();
  private void Full(){
      Photos.put("shower",shower);
      Photos.put("Duty",Duty);
      Photos.put("Hall",Hall);
      Photos.put("Tennis",Tennis);
      Photos.put("Administration",Administration);
      Photos.put("fk",fk);
      Photos.put("sk",sk);
      Photos.put("tk",tk);
      Photos.put("lk",lk);
      Photos.put("fb",fb);
      Photos.put("sb",sb);
      Photos.put("tb",tb);
      Photos.put("lb",lb);
      Photos.put("flc",flc);
      Photos.put("slc",slc);
      Photos.put("tlc",tlc);
      Photos.put("llc",llc);
      Photos.put("frc",frc);
      Photos.put("src",src);
      Photos.put("trc",trc);
      Photos.put("lrc",lrc);
  }
  public FotoContainer(){
      Full();
  }
  public InputFile get(String name){
      return Photos.get(name);
  }
}

