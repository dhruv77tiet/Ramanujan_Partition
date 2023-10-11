import java.util.Scanner ; 
import java.util.Arrays;
import java.util.ArrayList ; 
// NOTE: Please note that this is a simple algorithm of the partition theory worked by Indian Mathematician Ramanujan and his British mentor GH Hardy and please input small numbers only to find out how many different ways a natural number can be broken down into piece(s) of Natural numbers

public class Ramanujan_Partition{
	public static void main(String[] args) { 
		System.out.println("Enter the Natural Number of which you want to find the number of partitions: ");
		int dhruv_sud = 1;
		Scanner input = new Scanner(System.in); 
		int number_final = input.nextInt();
		int[] base_array = new int[number_final];
		for(int i = 0; i <= number_final-1; i++){
			base_array[i] = 1;
		}
		// System.out.println(Arrays.toString(base_array)); 
		int[] temp_array1 = new int[number_final];
		for(int i = 0; i <= number_final-1; i++){
			temp_array1[i] = base_array[i];
		}
		int[] temp_array2 = new int[number_final];
		int first_fixed_value = 1;
		int second_fixed_value = 1;
		int iteration_variable = 7;
		int m = 1;
		int n = 1;
		int location = number_final-1;
		String Finale = "continue";
		ArrayList<int[]> storage = new ArrayList<>();
		int[] final_addition = new int[number_final];
		for(int i = 0; i <= number_final-1; i++){
		final_addition[i] = 1;
		}
		storage.add(final_addition);
		// storage.add(new int[]{number_final-1, 1});
		while(!Finale.equals("exit")){
		for(int i = 0; i <= number_final-1; i++){
			iteration_variable = temp_array1[i];
			if(iteration_variable == 0){
				location =  i;
				break;
			}
			}
		if(m != 1 && n != 1){
			location = location-1;
		}
		n++;
		///int value_detector = 7;
		for(int i = location; i >= 2; i--){
			temp_array1[i-1] = temp_array1[i] + temp_array1[i-1];
			temp_array1[i] = 0;
			set_function(temp_array1, temp_array2, number_final);
			int[] temp_array27 = new int[temp_array2.length];
			for(int t = 0; t <= temp_array27.length -1; t++){
				temp_array27[t] = temp_array2[t];
			}
			storage.add(temp_array27);
		}	
		if(temp_array1[1] == temp_array1.length - first_fixed_value){
			second_fixed_value = second_fixed_value + 1;
			if(second_fixed_value == temp_array1.length - first_fixed_value){
				first_fixed_value = first_fixed_value + 1;
				second_fixed_value = 1;
				main_setting_function(temp_array1, first_fixed_value, second_fixed_value);
			}
			main_setting_function(temp_array1, first_fixed_value, second_fixed_value);
		}
		if(first_fixed_value == temp_array1.length - 1){
			Finale = "exit";
			break;
		}
		// System.out.println("hello"); 
		// System.out.println(storage);

}	
storage.add(new int[]{number_final});
sorting_function(storage);
int eliminating_number = eliminating_function(storage, number_final, dhruv_sud);
ArrayList<ArrayList<Integer>> Conversion_Array = new ArrayList<>();
for(int i = 0; i <= storage.size() -1; i++){
	Conversion_Array.add(new ArrayList<>());
}
for(int i = 0; i <= storage.size() -1; i++){
	
	for(int j = 0; j <= storage.get(i).length -1; j++){
		int value = storage.get(i)[j];
		Conversion_Array.get(i).add(value);

	}
}
//printing_function(storage);
ArrayList<ArrayList<Integer>> Storage = new ArrayList<>();
Storage = Conversion_Array;
eliminating_functionO(Storage);
// System.out.println(Storage);
ArrayList<Integer> temporary= new ArrayList<>();
for(int i = 0; i <= number_final-1; i++){
	temporary.add(1);
}
for(int i = 1; i <= eliminating_number; i++){
Storage.remove(temporary);}
ArrayList<Integer> final_adding = new ArrayList<>();
for(int i = 0; i <= number_final-1; i++){
final_adding.add(1);
}
Storage.add(final_adding);
System.out.println("The final answer is that the number of partitions of the number you input is: "+Storage.size());
beautiful_printing_function(Storage);
}

public static void set_function(int[] temp_array11,int[] temp_array22,int number_finall){
	for(int i = 0; i <=number_finall -1; i++){
		temp_array22[i] = temp_array11[i];
	}
}

static void main_setting_function(int[] temp_array1, int first_fixed_value, int second_fixed_value){
	int sum = first_fixed_value + second_fixed_value;
	int limiter = temp_array1.length;
	temp_array1[0] = first_fixed_value;
	temp_array1[1] = second_fixed_value;
	for(int i = 2; i <= limiter -1; i++){
		if(sum != limiter){
			temp_array1[i] = 1;
			sum = sum + temp_array1[i];
		}
		else if(sum == limiter){
			temp_array1[i] = 0;
		}
		
	}
}
static void printing_function(ArrayList<int[]> storage){
	for(int i = 0; i <= storage.size() -1; i++){
		System.out.println(Arrays.toString(storage.get(i))); 
	}
}
static int eliminating_function(ArrayList<int[]> storage, int number_final, int dhruv_sud){
	for(int i = 0; i <= storage.size() -1; i++){
		int[] temp = storage.get(i);
		int location = i;
		for(int j = 0; j <= storage.size() -1; j++){
			if(Arrays.equals(storage.get(j),temp) == true && j != location){
				dhruv_sud++;
				for(int k = 0; k <= temp.length-1; k++){
					storage.get(j)[k] = 1;
				}
			}
		}	
	}
return dhruv_sud;
}
static void sorting_function(ArrayList<int[]> storage){
	for(int i = 0; i <= storage.size() -1; i++){
		Arrays.sort(storage.get(i));
	}
}
static void eliminating_functionO(ArrayList<ArrayList<Integer>> Storage){
	 int value_to_remove = 0;
	for(int i =0; i <= Storage.size() -1; i++){
		while(Storage.get(i).get(0) == value_to_remove && Storage.get(i).isEmpty() != true){
			Storage.get(i).remove(0);
	}
}
}
static void beautiful_printing_function(ArrayList<ArrayList<Integer>> Storage){
	for(int i = 0; i <= Storage.size() -1; i++){
		for(int j =0; j <= Storage.get(i).size() -1; j++){
			System.out.print(Storage.get(i).get(j));
			if(j != Storage.get(i).size() -1){
				System.out.print(" + "); 
			}
		}
		System.out.println(""); 
	}
}

}
