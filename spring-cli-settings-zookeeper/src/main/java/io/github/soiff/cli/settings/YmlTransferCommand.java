package io.github.soiff.cli.settings;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import joptsimple.OptionSpecBuilder;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.options.OptionHelp;
import org.springframework.boot.cli.command.status.ExitStatus;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangh on 12/5/2016.
 *
 * @author : zhangh@dtdream.com
 * @version : 1.0.0
 * @since : 1.8
 */
public class YmlTransferCommand extends OptionParsingCommand {
    private static final Logger log = LoggerFactory.getLogger(YmlTransferCommand.class);

    private static final OptionHandler OPTION_HANDLER = new YmlTransferOptionHandler();

    protected YmlTransferCommand() {
        super("yml", "Transfer YML settings to zookeeper", OPTION_HANDLER);
    }

    @Override
    public String getUsageHelp() {
        return OPTION_HANDLER.getHelp();
    }

    public static class YmlTransferOptionHandler extends OptionHandler {

        private static final String[] OPTIONS = new String[] {
            "key", "path", "zookeeper"
        };
        private static final String HELP = "[key] <path> [zookeeper]";
        private OptionSpec<String> key;
        private OptionSpec<String> zookeeper;

        @Override
        protected void options() {
            key = option(Arrays.asList("key", "k"), "Optional root key in zookeeper").withOptionalArg();
            zookeeper = option(Arrays.asList("zookeeper", "zk"), "Optional zookeeper connection string").withOptionalArg();
        }

        @Override
        public String getHelp() {
            return HELP;
        }

        @Override
        public Collection<OptionHelp> getOptionsHelp() {
            return Collections.singletonList(new OptionHelp() {
                @Override
                public Set<String> getOptions() {
                    return new HashSet<>(Arrays.asList(OPTIONS));
                }

                @Override
                public String getUsageHelp() {
                    return HELP;
                }
            });
        }

        @Override
        protected ExitStatus run(OptionSet options) throws Exception {
            final String prefix = options.has(key) ? (String) options.valueOf(key) : "";
            final String zk = options.has(zookeeper) ? (String) options.valueOf(zookeeper) : "127.0.0.1:2181";
            final List<?> files = options.nonOptionArguments();
            final ZooKeeper keeper = new ZooKeeper(zk, 3000, watchedEvent ->
                log.info("Watched event : {}", watchedEvent));
            return null;
        }
    }
}
