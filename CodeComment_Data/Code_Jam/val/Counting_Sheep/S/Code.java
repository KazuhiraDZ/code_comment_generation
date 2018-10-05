package methodEmbedding.Counting_Sheep.S.LYD813;


import java.util.*;

public class Code{

 

public static void main(String[] args) {
	    List<Integer> digits = new ArrayList<Integer>();
	    int i,n,name,got,j;
	    int[] si = {
	    		0,
	    		1,
	    		2,
	    		11,
	    		90,
	    		150,
	    		5,
	    		168,
	    		64,
	    		82,
	    		81,
	    		13,
	    		17,
	    		21,
	    		37,
	    		128,
	    		200,
	    		35,
	    		7,
	    		14,
	    		199,
	    		61,
	    		34,
	    		6,
	    		125,
	    		57,
	    		88,
	    		84,
	    		3,
	    		26,
	    		102,
	    		166,
	    		186,
	    		65,
	    		59,
	    		184,
	    		103,
	    		76,
	    		196,
	    		182,
	    		121,
	    		86,
	    		185,
	    		101,
	    		51,
	    		9,
	    		109,
	    		4,
	    		98,
	    		138,
	    		42,
	    		136,
	    		10,
	    		134,
	    		79,
	    		8,
	    		157,
	    		75,
	    		105,
	    		153,
	    		92,
	    		45,
	    		133,
	    		106,
	    		144,
	    		156,
	    		135,
	    		160,
	    		80,
	    		43,
	    		83,
	    		112,
	    		97,
	    		140,
	    		172,
	    		180,
	    		58,
	    		113,
	    		169,
	    		40,
	    		99,
	    		163,
	    		171,
	    		85,
	    		70,
	    		48,
	    		181,
	    		25,
	    		124,
	    		96,
	    		108,
	    		161,
	    		148,
	    		20,
	    		155,
	    		78,
	    		36,
	    		29,
	    		151,
	    		162

	    };
	    for(j=0;j<si.length;j++){
	    	n = si[j];
	    	for(i=1;i<200;i++){
	    		name = i * n;
	    		if(name == 0){
	    			System.out.println("Case #"+ (j+1) +": INSOMNIA" );
	    			break;
	    		}else{
	    			while (name > 0) {
		    			got = name % 10;
		    			if (!digits.contains(got)) {
		    				digits.add(got);
		    			}
		    			name /= 10;
		    		}
		    		if(digits.size() == 10){
		    			System.out.println("Case #"+ (j+1) +": " + i*n);
		    			digits.clear();
		    			break;
		    		}
	    		}
	    		
	    		
	    	}
		}
	}
}
