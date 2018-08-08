package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy{
	 int pageSize ,
	 blockSize ,	
	 beginPage ,
	 endPage , 
	 rowCount ,
	 pageNum ,
	 beginRow , 
	 endRow, 
	 pageCount ,
	 blockCount ,
	 prevBlock ,
	 nextBlock;
	boolean existPrev, existNext;
	HttpServletRequest request;
	@Override
	public void carryout(Object o) {
		this.rowCount = MemberServiceImpl.getInstance().countMember();
		this.pageSize = 5;
		this.blockSize = 5;	
		this.beginPage = 0;
		this.endPage = 0; 
		this.pageNum = (int) o; 
		this.beginRow = 0; //String.valueOf(4*(pageNum-1)+pageNum);
		this.endRow= 0; //String.valueOf(pageNum*5);
		this.pageCount =  (int) Math.ceil(rowCount/(double)pageSize);	//14
		this.blockCount = (int) Math.ceil(pageCount/(double)blockSize); //3
		beginPage = pageNum - ((pageNum-1)%blockSize);
		endPage = ((beginPage + pageSize -1) < pageCount)?
				beginPage+blockSize-1:pageCount;
		beginRow = pageNum*pageSize - (pageSize-1);
		endRow = pageNum*pageSize;
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev = (prevBlock >=0);
		System.out.println(">>>>"+existPrev);
		this.existNext = false;
		if(nextBlock <= pageCount) {
		this.existNext = true;
		}
		
	};

}
