package pl.jakubtrzcinski.garminconnect;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import pl.jakubtrzcinski.garminconnect.token.CachingTokenSupplierDecorator;
import pl.jakubtrzcinski.garminconnect.token.TokenSupplier;
import pl.jakubtrzcinski.garminconnect.token.UserPasswordTokenSupplier;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@RequiredArgsConstructor
public class GarminConnectClient {

    @Delegate
    private final ActivityRepository activityRepository;

    @Delegate
    private final HeartRateRepository heartRateRepository;

    public static GarminConnectClient fromLoginPassword(String login, String password){
        return new GarminConnectClient(
                new CachingTokenSupplierDecorator(
                        new UserPasswordTokenSupplier(login, password)
                )
        );
    }

    public GarminConnectClient(TokenSupplier tokenSupplier) {
        activityRepository = new ActivityRepository(tokenSupplier);
        heartRateRepository = new HeartRateRepository(tokenSupplier);
    }
}
