package pl.jakubtrzcinski.garminconnect.token;

import lombok.RequiredArgsConstructor;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */

@RequiredArgsConstructor
public class CachingTokenSupplierDecorator implements TokenSupplier {

    private GarminToken cached;

    private final TokenSupplier supplier;

    @Override
    public GarminToken get() {
        if(cached == null){
            cached = supplier.get();
        }
        return cached;
    }
}
