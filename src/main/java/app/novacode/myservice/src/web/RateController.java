package app.novacode.myservice.src.web;


import app.novacode.myservice.src.domain.entity.RateDomain;
import app.novacode.myservice.src.domain.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    RateService rateService;


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


    @PostMapping()
    public RateDomain saveRate(@ModelAttribute RateDomain rateDomain){
        return rateService.saveRate(rateDomain);
    }

    @PutMapping
    public RateDomain updateRate(@ModelAttribute RateDomain rateDomain){
        return rateService.updateRate(rateDomain);
    }


}
