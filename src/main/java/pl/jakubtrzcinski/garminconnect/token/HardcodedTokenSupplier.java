package pl.jakubtrzcinski.garminconnect.token;

import lombok.RequiredArgsConstructor;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@RequiredArgsConstructor
public class HardcodedTokenSupplier implements TokenSupplier {
    private final String sessionId;
    private final String sso;

    public HardcodedTokenSupplier(GarminToken token){
        sessionId = token.getSessionId();
        sso = token.getSsoGuid();
    }
    @Override
    public GarminToken get() {
        return new GarminToken(
                sessionId,
                sso
        );
    }
}
