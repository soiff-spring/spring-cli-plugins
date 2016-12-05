package io.github.soiff.cli.settings;

import org.springframework.boot.cli.command.AbstractCommand;
import org.springframework.boot.cli.command.status.ExitStatus;

/**
 * Created by zhangh on 12/5/2016.
 *
 * @author : zhangh@dtdream.com
 * @version : 1.0.0
 * @since : 1.8
 */
public class YmlTransferCommand extends AbstractCommand {

    protected YmlTransferCommand() {
        super("yml", "Transfer YML settings to zookeeper");
    }

    @Override
    public ExitStatus run(String... strings) throws Exception {
        return null;
    }

}
