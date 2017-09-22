package matdate;


import matdate.generator.util.GeneratorConfigXml;
import matdate.generator.util.GeneratorMetadata;

/**
 * Created by john on 2016/4/8.
 */
public class Generator {
    public static void main(String[] args) {
        String generatorConfigPath = GeneratorConfigXml.generate();
        GeneratorMetadata.remove();
        GeneratorMetadata.generate(generatorConfigPath);
    }
}
