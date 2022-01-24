import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum loc {
    Кухня(01),Умывальники(02),Коридор_право(03),Коридор_лево(04);

    private final int id;
}
