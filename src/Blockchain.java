import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Blockchain {
	private List<Block> chain;
	
	public Blockchain() {
		chain = new ArrayList<Block>();
		chain.add(generateGenesis());
	}
	
	private Block generateGenesis() {//initialise genesis block 
		Block genesis = new Block("0x200", new Date(), "<transactions>");
		genesis.setPreviousHash(null);
		genesis.computeHash();
		return genesis;
	}
	
	public void addBlock(Block blk) {//adds a new block to the chain
		Block newBlock = blk;
		newBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
		newBlock.computeHash();
		this.chain.add(newBlock);
	}
	
	public void displayChain() {//this displays the chain
		
		for(int i=0; i<chain.size(); i++) {
			System.out.println("Block: " + i);
			System.out.println("Version: " + chain.get(i).getVersion());
			System.out.println("Timestamp: " + chain.get(i).getTimestamp());
			System.out.println("PreviousHash: " + chain.get(i).getPreviousHash());
			System.out.println("Hash: " + chain.get(i).getHash());
			System.out.println();
		}
		
	}
	
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
	
	public void isValid() {
		
		for(int i=chain.size()-1; i>0; i--) {
			if(   !(chain.get(i).getHash().equals(chain.get(i).computeHash()))   ) {
				System.out.println("Chain is not valid");
				return;
			}
			
			if(  !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash()))  ) {
				System.out.println("Chain is not valid");
				return;
			}
		}
		
		System.out.println("Chain is valid.");
		
	}

}
