package me.ashydev.iframework.basic.item.components;

import me.ashydev.iframework.framework.item.component.LoreComponent;
import me.ashydev.iframework.framework.util.Color;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleLoreComponent implements LoreComponent {
    private final ArrayList<String> lore;

    public SimpleLoreComponent(ArrayList<String> lore) {
        this.lore = lore;
    }

    public SimpleLoreComponent(String... lore) {
        this.lore = new ArrayList<>(Arrays.asList(lore));
    }

    @Override
    public List<Component> draw() {
        List<Component> components = new ArrayList<>();

        for (String line : lore)
            components.add(Color.colorize(line));

        return components;
    }

    public ArrayList<String> getLore() {
        return lore;
    }

    public static class Builder {
        private final ArrayList<String> lore = new ArrayList<>();

        public Builder lines(String... lines) {
            lore.addAll(Arrays.asList(lines));
            return this;
        }

        public Builder setLine(int index, String line) {
            lore.set(index, line);
            return this;
        }

        public Builder addLine(String line) {
            lore.add(line);
            return this;
        }

        public Builder addLines(String... lines) {
            lore.addAll(Arrays.asList(lines));
            return this;
        }

        public Builder removeLine(int index) {
            lore.remove(index);
            return this;
        }

        public Builder removeLine(String line) {
            lore.remove(line);
            return this;
        }

        public SimpleLoreComponent build() {
            return new SimpleLoreComponent(lore);
        }
    }

}
