import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuziyang on 2017/7/28.
 */
public class ArrayTest {
    public static void main(String[] args) throws Exception {
        System.out.println();
        List<String> list = new ArrayList<>();
        list.add("haha");
        User user = new User();
        Field[] fields = user.getClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType().getSimpleName());
            if ("String".equalsIgnoreCase(field.getType().getSimpleName())){
                field.set(user,"hahaha");
            }
            if ("List".equalsIgnoreCase(field.getType().getSimpleName())){
                Class<?> clazz = (Class<?>) ((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0];
                System.out.println(clazz.toString());
                Object str = clazz.getConstructor().newInstance();
                List<Object> list1 = new ArrayList<>();
                list1.add(str);
                field.set(user,list1);
            }
        }
        System.out.println(user);
    }

    static class User{
        public String name;
        public List<String> list;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", list=" + list +
                    '}';
        }
    }
}
