import java.util.*;
public class PhoenixCoin {

	public static void main(String[] args) {
		Blockchain phoenixCoin =new Blockchain();
		Block a = new Block("0x200", new java.util.Date(), "<transactions>");
		Block b = new Block("0x200", new java.util.Date(), "<transactions>");
		Block c = new Block("0x200", new java.util.Date(), "<transactions>");
		
		phoenixCoin.addBlock(a);
		phoenixCoin.addBlock(b);
		phoenixCoin.addBlock(c);
		
		
		phoenixCoin.displayChain();
		
	}

}
