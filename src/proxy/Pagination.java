package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Capable{
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
	String searchWord,column;
	boolean existPrev, existNext, existWord;
	HttpServletRequest request;
	@Override
	public void carryout(Map<?, ?> param) {
		System.out.println("c. proxy페이지네이션서 로카운트 찍기");
		//만약 컬럼값이 있으면 컬럼넣어주고 없으면 param에 기본값 풋해줘야해 ㅎg 
		Map<String, Object> map = new HashMap<>();
		this.searchWord = null;
		this.column = null;
		if(!param.containsKey("column")) {
			map.put("column", "MEMID");
			map.put("value", "%");
			System.out.println("컬럼값이 없습니다 ");
			this.rowCount = MemberServiceImpl.getInstance().countMember(map);
			this.existWord = false;
		}else {
			System.out.println("칼럼값이 있스무니다 " + param.get("column"));
			this.rowCount = MemberServiceImpl.getInstance().countMember(param);
			this.existWord = true;
			this.searchWord = param.get("value").toString();
			this.column = param.get("column").toString();
		}
		System.out.println("g. 최종 rowcount "+this.rowCount);
		this.pageSize = 5;
		this.blockSize = 5;	
		this.beginPage = 0;
		this.endPage = 0; 
		this.pageNum = (int) param.get("pageNum");
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
