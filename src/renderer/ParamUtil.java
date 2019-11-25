package renderer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class ParamUtil {
    private ParamUtil() {}

    public static Map<String, String> parseQueryString(String query) {
        System.out.println(query);
        // 파라미터가 없다면(e.g. localhost:8000/ OR localhost:8000?) null을 반환한다.
        if (query == null) {
            return null;
        }

        Map<String, String> params = new HashMap<String, String>();

        String[] queryElements = query.split("[&]");
        for (String queryElement : queryElements) {
            int index = queryElement.indexOf('=');
            if (index < 0) {
                // key만 존재하고 value가 지정되지 않을 경우 (e.g. localhost:8000/name=) 키만 저장한다.
                params.put(decode(queryElement), null);
            } else {
                // key와 value가 모두 존재할 경우 (e.g. localhost:8000/name=john) key&value를 모두 저장한다.
                String key = decode(queryElement.substring(0, index));
                String value = decode(queryElement.substring(index + 1));
                params.put(key, value);
                System.out.println(key + " : " + value);
            }
        }
        return params;
    }

    private static String decode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "?";
        }
    }
}
