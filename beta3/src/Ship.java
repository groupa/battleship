import java.util.ArrayList;
/**
 * 
 * @author Amir Almasi
 * 
 */

public class Ship {
	public ArrayList <Integer> Indexes = new ArrayList <Integer> ();
	public boolean destroyed_Flag=false;
	public int length , horVar;
	public Ship() {
		// TODO Auto-generated constructor stub	
	}
	public Ship (int firstIndex,int lenght , int horVer){
		this.length=lenght;
		this.horVar=horVer;
		if (horVer !=1){ //horizontal
			for (int i = firstIndex; i <firstIndex + lenght ;i++)
				Indexes.add(i);
		}else {
			for (int i = firstIndex; i <(lenght * 10)+firstIndex;i+=10)
				Indexes.add(i);
		}
	}
	public boolean is_Destroyed(ArrayList index){
		boolean flag;
		for (int i = 0;i<Indexes.size();i++){
			flag=false;
			for (int j=0;j<index.size();j++)
				if(Indexes.get(i)==index.get(j)){
					flag=true;
					break;
				}
			if (!flag)
				return false;
		}
		destroyed_Flag=true;
		return destroyed_Flag;

	}


}
