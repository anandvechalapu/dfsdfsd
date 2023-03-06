
@RestController
public class SwamiConfigurationController {

    private final SwamiConfigurationService swamiConfigurationService;

    @Autowired
    public SwamiConfigurationController(SwamiConfigurationService swamiConfigurationService) {
        this.swamiConfigurationService = swamiConfigurationService;
    }

    @PostMapping("/configuration/{service}")
    public void configureSwami(@PathVariable("service") String service, @RequestBody SwamiConfiguration configuration) {
        swamiConfigurationService.configureSwami(service, configuration);
    }

}

@Service
public class SwamiConfigurationService {

    private final SwamiConfigurationRepository swamiConfigurationRepository;

    @Autowired
    public SwamiConfigurationService(SwamiConfigurationRepository swamiConfigurationRepository) {
        this.swamiConfigurationRepository = swamiConfigurationRepository;
    }

    public void configureSwami(String service, SwamiConfiguration configuration) {
        swamiConfigurationRepository.save(service, configuration);
    }
}

@Repository
public class SwamiConfigurationRepository {

    private final Map<String, SwamiConfiguration> swamiConfigurations;

    @Autowired
    public SwamiConfigurationRepository(Map<String, SwamiConfiguration> swamiConfigurations) {
        this.swamiConfigurations = swamiConfigurations;
    }

    public void save(String service, SwamiConfiguration configuration) {
        swamiConfigurations.put(service, configuration);
    }

}