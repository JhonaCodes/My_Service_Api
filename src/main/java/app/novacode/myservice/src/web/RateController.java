package app.novacode.myservice.src.web;


import app.novacode.myservice.src.domain.entity.BusinessDomain;
import app.novacode.myservice.src.domain.entity.RateDomain;
import app.novacode.myservice.src.domain.service.BusinessService;
import app.novacode.myservice.src.domain.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    RateService rateService;

    @Autowired
    BusinessService businessService;


    @GetMapping("/total_rate/{businessIdT}")
    public Optional<Double> totalRates(@PathVariable("businessIdT") String buseinessId){

        return rateService.getTotalQualifier(buseinessId);
    }


    @GetMapping("/total_qualifiers/{businessIdQ}")
    public Optional<Double> totalQualifiers(@PathVariable("businessIdQ") String businessId){
        return rateService.getTotalRates(businessId);
    }


    @GetMapping("/{email}")
    public Optional<RateDomain> getByRateEmail(@PathVariable("email") String email){
        return rateService.getRateByEmail(email);
    }


    @GetMapping("/my_rates/{busionessIdM}")
    public Optional<List<RateDomain>> getMyRates(@PathVariable("busionessIdM") String busionessID){
        return rateService.getListRates(busionessID);
    }


    @GetMapping("/media/{businessId}")
    public Map<String, Object> medianRate(@PathVariable("businessId") String bId){

        Double finalRate = totalRates(bId).get() / totalQualifiers(bId).get();

        Map<String, Object> rateFinal = new HashMap<>();

        rateFinal.put("rate", finalRate);


        return rateFinal;

    }

    @PostMapping()
    public Map<String, Object> saveRate(@RequestBody RateDomain rateDomain){

        // Create a data tipe Map
        Map<String, Object> result = new HashMap<>();

        // boolean expresion if value exist
        boolean rateIsPresent = rateService.getRateByEmail(rateDomain.getMailRated()).isPresent();

        if(rateIsPresent){

            // Search registre and assign to variable
            RateDomain rateDomain1 = rateService.getRateByEmail(rateDomain.getMailRated()).get();


            // Verify if information is equal and the same client
            if(rateDomain.getBusinessID().equals(rateDomain1.getBusinessID()) && rateDomain.getMailRated().equals(rateDomain1.getMailRated()) ){

                // Change Rate Qualification
                rateDomain1.setRate(rateDomain.getRate());

                // remplace initial value for the final value
                rateDomain = rateDomain1;

            }

        }

        // Assign Value for result and insert rate value
        result.put("result", rateService.saveRate(rateDomain));


        // Start instancia for business rated, using a find for business service
        Optional<BusinessDomain> businessDomain = businessService.findByBusinessId(rateDomain.getBusinessID());

        // Calculate media of rate for Business ID
        double rateBusiness =  totalRates(rateDomain.getBusinessID()).get() / totalQualifiers(rateDomain.getBusinessID()).get();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);


        // Calculate value if the rest by 0.5 is equal to 0 so continue whit same value, but is not equal to 0 use doble format and delete all decimal values and save the integer value
        double finalRate = rateBusiness % 0.5d == 0? rateBusiness : Double.parseDouble(df.format(rateBusiness));


        // Insert New Rate Media on business
        businessDomain.get().setRate(finalRate);

        // Save on data base Business whit a new Rate
        businessService.saveBusiness(businessDomain.get());

        // Return result of post request values.
        return result;
    }

    @PutMapping
    public RateDomain updateRate(@RequestBody RateDomain rateDomain){
        return rateService.updateRate(rateDomain);
    }


}
