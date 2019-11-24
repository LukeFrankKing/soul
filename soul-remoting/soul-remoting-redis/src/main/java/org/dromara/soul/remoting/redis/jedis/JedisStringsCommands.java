/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.dromara.soul.remoting.redis.jedis;

import org.dromara.soul.common.exception.SoulException;
import org.dromara.soul.remoting.redis.command.RedisStringsCommands;

/**
 * JedisStringsCommands .
 *
 * @author sixh
 */
public class JedisStringsCommands implements RedisStringsCommands {

    private JedisSingleConnection connection;

    public JedisStringsCommands(JedisSingleConnection connection) {
        this.connection = connection;
    }

    @Override
    public byte[] get(byte[] key) {
        try {
            return connection.execute(jedis -> jedis.get(key));
        } catch (RuntimeException ex) {
            throw new SoulException(ex);
        }
    }

    @Override
    public void set(byte[] key, byte[] value) {
        try {
            connection.execute(jedis -> jedis.set(key, value));
        } catch (RuntimeException ex) {
            throw new SoulException(ex);
        }
    }
}