package week5;

public class assign1 {
	  public static void main(String[] args) {
	    IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
	    iptv.printProperty();
	  }
	}
	class TV {
	  private int size;
	  public TV() {}
	  public TV(int size) { this.size = size; }
	  public int getSzie() {return size;}
	  protected int getSize() { return size; }
	}
	class ColorTV extends TV{
		private int color;
		public int getColor() {return color;}
		public ColorTV() {};
		public ColorTV(int size, int color) {super(size); this.color = color;};
	}
	class IPTV extends ColorTV{
		private String ip;
		public String getIp() {return ip;}
		public IPTV(String ip, int size, int color) {super(size,color); this.ip = ip;}
		public void printProperty() {
			System.out.println("나의 IPTV는 " + getIp()+ " 주소의 "+ getSzie() + "인치 "+ getColor()+"컬러");
		}
		
	}