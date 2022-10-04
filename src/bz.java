
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Date 2022/9/10 23:43
 * @Created by WeiFeng
 */
public class bz {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] data = "{\"data\":{\"page\":\"1\"},\"deviceId\":\"99db23ff676cb344\",\"token\":\"e9bd5782c06217fc32d82313c756aa8f_7134213\"}".getBytes(StandardCharsets.UTF_8);
        // [123, 34, 100, 97, 116, 97, 34, 58, 123, 34, 112, 97, 103, 101, 34, 58, 34, 49, 34, 125, 44, 34, 100, 101, 118, 105, 99, 101, 73, 100, 34, 58, 34, 57, 57, 100, 98, 50, 51, 102, 102, 54, 55, 54, 99, 98, 51, 52, 52, 34, 44, 34, 116, 111, 107, 101, 110, 34, 58, 34, 101, 57, 98, 100, 53, 55, 56, 50, 99, 48, 54, 50, 49, 55, 102, 99, 51, 50, 100, 56, 50, 51, 49, 51, 99, 55, 53, 54, 97, 97, 56, 102, 95, 55, 49, 51, 52, 50, 49, 51, 34, 125]
        System.out.println(new String(data, StandardCharsets.UTF_8));

        SecretKeySpec secretKeySpec = new SecretKeySpec("c31b32364ce19c13".getBytes(), "AES-128-ECB");
        System.out.println(Arrays.toString("c31b32364ce19c13".getBytes()));
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);

        byte[] bArr2 = cipher.doFinal(data);
        System.out.println(bArr2);
//        String s = "2Id>w��Қ\u001Ft�\u000E�C�ʭ�;�5�n��e�\u001F\u0012U*�\u0005\u000B>\f\u0002~�ʘA�]M�\u0018o\u0010�\u001D)\u001D\u0011$�Ob�K%p���4��P\u001Do�M���\u0007�\u000E\u0016\u000F\u001A�ݗR9������͇\u001B�i:bi��\u000F����yW[��Y�v,�,��\u001Cp^�!��4-�OP�q�\u0010ѻ#�\u0012\u0018��5u\f\u000F��W�\\$\u0002d�p�\u0014=\\��E\t�,�P ��j:'��\f��F�O�x��C��\u05FB��\u001E-\u000E\u0003�\u0011,�@�(xgk�T��+X�K\u0005ȏ����yk`7\u0004��\u0602B\u00141��\u00146 ]���|\u001D�j��\tr\u001F0`�J�賷����!>B\u001B�\u0007�y�Y�\u0002]F�\u0006��5�\u0004��Y4AJ��U@$H�\u000F7رz�x]�ց�\u000F�!X���\u000E�t6\u0010\u0015��]x.%�\u0011�k�3]�\\�Gr\u0015��O�5\n" +
//                "    i \u001B���r;e\u001D��;f-IQ��i��JN�-G�,�\u0014:\"�\tخ�s�\u00048PÂuh�D���\u0016\"�������\u0003\f�\u0003�iy\\\u00185��nv���\u0003{ZZ�\u05EB��b�>\u0011VeҔRt����[����-\u001Dk!6SG\t\u001D�R�cR���h�l�j*�9\u001CP$�~�\tT�}�/�ʽ-�&;\u001B#�\\C�\u0005xQ>a\u0002�FX�\u000EE����i�К�!�V!zA�|y�x��W��K\u001D�3\u0002F�\u0012R?\u0016�qG�?�\u0011�X�&27��~�\u000ES����� ��実`Y\uF629?����E��Y\u0010i-*�����\u001E�l��k�R\u0018�&4&�\u0017o7�����i�\u0016\u007F���\n" +
//                "    [�ӕ�:�z�Ď�S���p��6���R���]���0A��'���6�|<�(�IE����\u001B)�0���ͩ\u0017\u0013\u001B� ��7����";
//        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8)));
    }

    public static final Pattern f11087e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern f11088f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");


//    public static void request(Object obj) {
//        byte[] bArr = null;
//        BaseRequestBody = new BaseRequestBody();
//        baseRequestBody.setDeviceId(string);
//        baseRequestBody.setToken(token + "_" + user_id);
//        baseRequestBody.setData(obj);
//        String jSONString = JSON.toJSONString(baseRequestBody);
//        byte[] bytes = jSONString.getBytes(StandardCharsets.UTF_8);
//        try {
//            SecretKeySpec secretKeySpec = new SecretKeySpec("c31b32364ce19c13".getBytes(), "AES-128-ECB");
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(1, secretKeySpec);
//            bArr = cipher.doFinal(bytes);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        assert bArr != null;
////        C5088z m706b = m706b("multipart/form-data");
//
////        new C4907f0(bArr, m706b, bArr.length, 0);
//    }

//    public static C5088z m707a(String str) {
//        Matcher matcher = f11087e.matcher(str);
//        if (matcher.lookingAt()) {
//            String group = matcher.group(1);
//            Locale locale = Locale.US;
//            String lowerCase = group.toLowerCase(locale);
//            String group2 = matcher.group(2);
//            Locale locale2 = Locale.US;
//            String lowerCase2 = group2.toLowerCase(locale2);
//            Matcher matcher2 = f11088f.matcher(str);
//            int end = matcher.end();
//            String str2 = null;
//            while (end < str.length()) {
//                matcher2.region(end, str.length());
//                if (matcher2.lookingAt()) {
//                    String group3 = matcher2.group(1);
//                    if (group3 != null && C0155e.m5304d(group3, "charset", true)) {
//                        String group4 = matcher2.group(2);
//                        boolean z = false;
//                        if (group4 == null) {
//                            group4 = matcher2.group(3);
//                            C0101i.m5351b(group4, "parameter.group(3)");
//                        } else if (C0155e.m5312C(group4, "'", false, 2) && C0155e.m5305c(group4, "'", false, 2) && group4.length() > 2) {
//                            group4 = group4.substring(1, group4.length() - 1);
//                            C0101i.m5351b(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
//                        }
//                        if (str2 == null || C0155e.m5304d(group4, str2, true)) {
//                            z = true;
//                        }
//                        if (z) {
//                            str2 = group4;
//                            end = matcher2.end();
//                        } else {
//                            throw new IllegalArgumentException(("Multiple charsets defined: \"" + str2 + "\" and: \"" + group4 + "\" for: \"" + str + '\"').toString());
//                        }
//                    } else {
//                        end = matcher2.end();
//                    }
//                } else {
//                    StringBuilder m3887w = outline.m3887w("Parameter is not formatted correctly: \"");
//                    String substring = str.substring(end);
//                    C0101i.m5351b(substring, "(this as java.lang.String).substring(startIndex)");
//                    m3887w.append(substring);
//                    m3887w.append("\" for: \"");
//                    m3887w.append(str);
//                    m3887w.append('\"');
//                    throw new IllegalArgumentException(m3887w.toString().toString());
//                }
//            }
//            //application/json; charset=UTF-8
//            //application
//            //json
//            //UTF-8
//            return new C5088z(str, lowerCase, lowerCase2, str2, null);
//        }
//        throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
//    }

}
