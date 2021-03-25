package test;

public class Converter {

	
	public void ColumnConverter(String col) {
		col = col.toLowerCase();
		String[] cols = col.split("\r\n");
		
		for(String c : cols) {
			while(c.contains("_")) {
				int i = 0;
				int idx = c.indexOf("_", i);
				String str = c.substring(idx+1, idx+2);
				c = c.replaceFirst("_"+str, ""+str.toUpperCase());
				i = idx;
			}
			if(c.contains("Num")) {
				System.out.println("private Long " + c);
			}else {
				System.out.println("private String " + c);
			}
		}
	}

	public static void main(String[] args) {
		Converter converter = new Converter();
		converter.ColumnConverter("FI_NUM\r\n"
				+ "FI_NAME\r\n"
				+ "FI_PRICE\r\n"
				+ "FI_TYPE\r\n"
				+ "FI_DESC\r\n"
				+ "CREDAT\r\n"
				+ "ACTIVE");
	}
}
