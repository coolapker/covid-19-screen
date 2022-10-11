package mojospy.covid19screen.domain.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    private String msg;
    private Boolean success;
    private T data;

    public static <T> R<T> ok(T data){
        return new R<T>("success",true,data );
    }

    public static <T> R<T> fail(T data) {
        return new R<T>("failed", false, data);
    }
}