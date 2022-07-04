package strings.math;

import java.util.Map;
import java.util.stream.Collectors;

	public class FrequencyMapTest {

		public FrequencyMapTest() {
		}

		public static void main(String[] args) {
			FrequencyMapTest mapTest = new FrequencyMapTest();
			mapTest.testNullString();
			mapTest.testEmptyString();
			mapTest.testSimpleLatinString();
			mapTest.testMultiLineString();
			mapTest.debug("all tests passed!");
		}
		
		// null string assert test
		public void testNullString() {
			try {
				FrequencyMap nullStrFreqMap = new FrequencyMap(null);
			} catch (AssertionError e) {
				String[] result = e.getMessage().split(System.lineSeparator());
				debug("null string assertion:" + result[0]);
			}
		}

		public void testEmptyString() {
			FrequencyMap emptyStrFreqMap = new FrequencyMap("");
			Map<String, Integer> map = emptyStrFreqMap.getFrequencyMap();
			debug("empty string map:" + mapToString(map));
			assert (mapToString(map).equals("{}")) : "empty string map representation should be equal '{}'";
		}

		public void testSimpleLatinString() {
			String str = "abcdef G h I j J G!";
			FrequencyMap emptyStrFreqMap = new FrequencyMap(str);
			Map<String, Integer> map = emptyStrFreqMap.getFrequencyMap();
			debug("simple latin string map:" + mapToString(map));
			assert (mapToString(map)
					.equals("{ =6, !=1, a=1, b=1, c=1, d=1, e=1, f=1, G=2, h=1, I=1, J=1, j=1}")
					) 
			: "simple latin string map map representation should be equal "
			 .concat("'{ =6, !=1, a=1, b=1, c=1, d=1, e=1, f=1, G=2, h=1, I=1, J=1, j=1}'");
		}

		public void testMultiLineString() {
			String str = "\tА я решил написать по-русски... \n С переносами на новую строку\n и табуляцией.\t";
			FrequencyMap emptyStrFreqMap = new FrequencyMap(str);
			Map<String, Integer> map = emptyStrFreqMap.getFrequencyMap();
			debug("multi line string map:" + mapToString(map));
		}

		/* TODO */
		public void testUnicodePairCharString() {
			
		}

		public void debug(String str) {
			System.out.println(str);
		};

		private String mapToString(Map<String, Integer> map) {
			String mapAsString = map.keySet().stream()
			.map(key -> key + "=" + map.get(key).toString())
			.collect(Collectors.joining(", ", "{", "}"));
			return mapAsString;
		}

	}
