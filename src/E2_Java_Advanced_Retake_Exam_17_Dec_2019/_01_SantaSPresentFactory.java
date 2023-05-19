package E2_Java_Advanced_Retake_Exam_17_Dec_2019;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class _01_SantaSPresentFactory {
    private static final int DOLL= 150;
    private static final int WOODEN_TRAIN= 250;
    private static final int TEDDY_BEAR= 300;
    private static final int BICYCLE= 400;

    public static void main(String[] args) {
        //STACK - PUSH, POP, PEEK
        //QUEUE - OFFER, POLL, PEEK

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> presents = new HashMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        //last box with materials- STACK and the first magic level value- QUEUE

        //read materials
        String [] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        for (String token: tokens){
            materials.push(Integer.parseInt(token)); //STACK
        }

        //read magic level
        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        for (String token: tokens){
            magicLevel.offer(Integer.parseInt(token)); //QUEUE
        }

        while (!materials.isEmpty() && !magicLevel.isEmpty()) {

            int currentMaterial = materials.peek();
            int currentMagicLevel = magicLevel.peek();

            if (currentMaterial == 0 || currentMagicLevel==0) {
                if(currentMaterial==0){
                    materials.pop();
                }
                if(currentMagicLevel==0){
                    magicLevel.poll();
                }
                continue;
            }
            int totalMagicLevel = currentMaterial * currentMagicLevel;
            if(totalMagicLevel<=0){
                //then you have to sum the values together, remove them both from their positions and the result should be added to the materials.
                int sum = currentMaterial+currentMagicLevel;
                magicLevel.pop();
                materials.poll();
                materials.push(sum);
            }
            else {

            switch (totalMagicLevel) {
                case DOLL:
                    int dollCounter = presents.get("Doll");
                    dollCounter++;
                    presents.put("Doll", dollCounter);
                    magicLevel.pop();
                    materials.poll();
                    break;
                case WOODEN_TRAIN:
                    int woodenTrainCounter = presents.get("Wooden train");
                    woodenTrainCounter++;
                    presents.put("Wooden train", woodenTrainCounter);
                    magicLevel.pop();
                    materials.poll();
                    break;
                case TEDDY_BEAR:
                    int teddyCounter = presents.get("Teddy bear");
                    teddyCounter++;
                    presents.put("Teddy bear", teddyCounter);
                    magicLevel.pop();
                    materials.poll();
                    break;
                case BICYCLE:
                    int bicycleCounter = presents.get("Bicycle");
                    bicycleCounter++;
                    presents.put("Bicycle", bicycleCounter);
                    magicLevel.pop();
                    materials.poll();
                    break;
                default:
                    //remove only the magic value and increase the material value by 15.
                    magicLevel.pop();
                    materials.poll();
                    currentMaterial += 15;
                    materials.push(currentMaterial);
                    break;
            }
            }


        }
        //Your task is considered done if you manage to craft either one of the pairs - a doll and a train or a teddy bear and a bicycle.
        if((presents.get("Doll")>0 && presents.get("Wooden train")> 0) || (presents.get("Teddy bear")>0 && presents.get("Bicycle")>0)){
            System.out.println("The presents are crafted! Merry Christmas!");
        }
        else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()){
            StringBuilder sbMaterials = new StringBuilder();
            materials.forEach(m -> sbMaterials.append(m).append(", "));
            sbMaterials.deleteCharAt(sbMaterials.length()-1);
            sbMaterials.deleteCharAt(sbMaterials.length()-1);
            System.out.printf("Materials left: %s%n", sbMaterials);
        }
        if (!magicLevel.isEmpty()){
            StringBuilder sbMagic= new StringBuilder();
            magicLevel.forEach(m->sbMagic.append(m).append(", "));
            sbMagic.deleteCharAt(sbMagic.length()-1);
            sbMagic.deleteCharAt(sbMagic.length()-1);
            System.out.printf("Magic left: %s%n", sbMagic);
        }
        presents.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    if (entry.getValue() > 0) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                });


    }
}
