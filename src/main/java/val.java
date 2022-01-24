import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum val {
    Душик(01),Теннис(02),Дежурка(03),Холл(04);

   private final int id;
}
