package by.coolout.bot;

import by.coolout.bot.entity.Drink;
import by.coolout.bot.service.DrinkService;
import by.coolout.bot.statics.Drinks;
import by.coolout.bot.statics.Volumes;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static by.coolout.bot.statics.Drinks.*;
import static by.coolout.bot.statics.Volumes.*;

@Profile("initdb")
@Component
@RequiredArgsConstructor
public class AppStartupRunner implements ApplicationRunner {

    private final DrinkService drinkService;

    @Override
    public void run(ApplicationArguments args) {
        List<Drink> drinks = new ArrayList<>();

        drinks.add(createDrink(ESPRESSO, VOLUME_20, 2.5));
        drinks.add(createDrink(ESPRESSO, VOLUME_42, 3.0));
        drinks.add(createDrink(AMERICANO, VOLUME_120, 2.7));
        drinks.add(createDrink(AMERICANO, VOLUME_300, 3.2));
        drinks.add(createDrink(CAPPUCCINO, VOLUME_180, 3.0));
        drinks.add(createDrink(CAPPUCCINO, VOLUME_250, 3.7));
        drinks.add(createDrink(CAPPUCCINO, VOLUME_350, 4.7));
        drinks.add(createDrink(LATTE, VOLUME_180, 3.3));
        drinks.add(createDrink(LATTE, VOLUME_250, 4.0));
        drinks.add(createDrink(LATTE, VOLUME_350, 5.0));
        drinks.add(createDrink(RAF, VOLUME_180, 3.5));
        drinks.add(createDrink(RAF, VOLUME_250, 4.4));
        drinks.add(createDrink(RAF, VOLUME_350, 5.1));
        drinks.add(createDrink(FLAT, VOLUME_180, 4.0));
        drinks.add(createDrink(MOCHACINO, VOLUME_180, 3.4));
        drinks.add(createDrink(MOCHACINO, VOLUME_250, 4.1));
        drinks.add(createDrink(MOCHACINO, VOLUME_350, 5.0));
        drinks.add(createDrink(COCOA, VOLUME_250, 2.8));
        drinks.add(createDrink(CHOCOLATE, VOLUME_250, 3.0));
        drinks.add(createDrink(CHILD_CAPPUCCINO, VOLUME_250, 2.0));
        drinks.add(createDrink(TEA, VOLUME_350, 2.0));
        drinks.add(createDrink(TEA_LATTE, VOLUME_250, 4.2));
        drinks.add(createDrink(TEA_MATCHA_GREEN, VOLUME_250, 5.0));
        drinks.add(createDrink(TEA_MATCHA_BLUE, VOLUME_250, 5.0));

        drinkService.saveAll(drinks);
    }

    private Drink createDrink(Drinks drinks, Volumes volumes, Double price) {
        Drink drink = new Drink();
        drink.setName(drinks.name());
        drink.setVolume(volumes.getVolume());
        drink.setPrice(price);
        return drink;
    }
}
