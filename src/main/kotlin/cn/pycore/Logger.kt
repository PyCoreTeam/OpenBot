package cn.pycore

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.nio.file.Path


object Logger {
    private val logger: Logger = LogManager.getLogger("OpenBot")

    fun info(msg: String) = logger.info(msg)
    fun warn(msg: String) = logger.warn(msg)
    fun error(msg: String) = logger.error(msg)
    fun debug(msg: String) = logger.debug(msg)
}