package net.mnm.adc.inventory;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller("/cars")
@ExecuteOn(TaskExecutors.IO)
public class CarController {

    @Get("/stock/{model}")
    public Boolean isStockAvailable(@NotNull @NotBlank @PathVariable final String model){
        return getCarInventory(model).map(carInventory -> carInventory.getStock() > 0).orElse(Boolean.FALSE);
    }

    private Optional<CarInventory> getCarInventory(@NotNull String model) {
        if(model.equalsIgnoreCase("XUV700")){
            return Optional.of(new CarInventory("XUV700", 5));
        }

        if(model.equalsIgnoreCase("ScorpioN")){
            return Optional.of(new CarInventory("ScorpioN", 0));
        }

        if(model.equalsIgnoreCase("Thar")){
            return Optional.of(new CarInventory("Thar", 20));
        }

        if(model.equalsIgnoreCase("XUV300")){
            return Optional.of(new CarInventory("XUV300", 30));
        }

        return Optional.empty();
    }

}
