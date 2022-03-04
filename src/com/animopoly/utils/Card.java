package com.animopoly.utils;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Card
{
    private static ArrayList<String> scenarios;

    public String content;
    public int profit;
    
    public Card()
    {
        this.scenarios = new ArrayList<String>();
        try(Scanner scanner = new Scanner(Paths.get("scenarios.txt")))
        {
            while(scanner.hasNextLine())
            {
                this.scenarios.add(scanner.nextLine());
            }
            
            Random generator = new Random();
            int offset = generator.nextInt(this.scenarios.size());
            this.content = this.scenarios.get(offset).split("---")[0];
            this.profit = Integer.valueOf(this.scenarios.get(offset).split("---")[1]);
        } catch (Exception e)
        {
            System.out.println("Error occured reading `scenarios.txt`");
            System.out.println(e);
        }
    }
    
    public String toString()
    {
        return "Content: " + this.content + "\nProfit: " + this.profit + "\n\n";
    }
}
