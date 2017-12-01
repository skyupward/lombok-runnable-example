package skyupward.lombok;

import lombok.Getter;
import lombok.Setter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SkyUpward
 * Created at 2017/11/13 21:44
 */
public class NonNullExample {

    @Setter @Getter @NonNull //custom @NonNull
    private String str;

    public NonNullExample(@lombok.NonNull String str) {
        super();
        this.str = str;
    }

    public Integer customNonNull(@NonNull /*custom @NonNull */ Integer integer){
        return integer;
    }

    public static void main(String... args){
        assertThrows(NullPointerException.class, () -> new NonNullExample(null));
        NonNullExample example = new NonNullExample("Hello Lombok!");
        assertNull(example.customNonNull(null)); //no null check
        assertThrows(NullPointerException.class, () -> example.setStr(null));
        assertEquals("Hello Lombok!", example.getStr());
    }

    public @interface NonNull{

    }

}
