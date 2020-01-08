package perococco.aoc.day14.computation.parser;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.day14.computation.Chemical;
import perococco.aoc.day14.computation.Reactant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReactionToken {

    private static final Pattern PRODUCT = Pattern.compile("(\\d+) +([A-Z]+)");

    @Getter
    private final String name;

    @Getter
    private final int amount;

    @NonNull
    public Reactant toReactant(@NonNull ImmutableMap<String,Chemical> chemicalByName) {
        return new Reactant(chemicalByName.get(name),amount);
    }

    public ReactionToken(String token) {
        final Matcher matcher = PRODUCT.matcher(token.trim());
        if (!matcher.matches()) {
            throw new AOCException("Cannot parse token : '" + token + "'");
        }
        this.name = matcher.group(2);
        this.amount = Integer.parseInt(matcher.group(1));
    }

}
